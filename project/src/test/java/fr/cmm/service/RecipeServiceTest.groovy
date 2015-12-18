package fr.cmm.service;

import fr.cmm.domain.Recipe;
import fr.cmm.helper.PageQuery;
import org.jongo.MongoCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import static fr.cmm.SpringProfiles.INTEG;
import static java.util.Arrays.asList;
import static java.util.stream.StreamSupport.stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ImageServiceTestConfig.class)
@ActiveProfiles(INTEG)
public class RecipeServiceTest {
    @Inject
    private RecipeService recipeService;

    @Inject
    private MongoCollection recipeCollection;

    @Before
    @After
    void clean() {
        recipeCollection.remove();
    }

    @Test
    void save() {
        recipeService.save(new Recipe(title: 'test title'))

        assert recipeCollection.findOne().as(Recipe).title == 'test title'
    }

    @Test
    void findById() {
        def recipe = new Recipe(title: 'test recipe')
        recipeService.save(recipe)

        assert recipeService.findById(recipe.id).title == 'test recipe'
    }

    @Test
    public void findByIdWithInvalidId() {
        assert recipeService.findById('123pasvalide456') == null
    }

    @Test
    public void findByQuery() {
        5.times { recipeService.save(new Recipe()) }

        assert recipeService.findByQuery(new PageQuery()).size() == 5
    }

    @Test
    public void findByQueryWithCustomPageSize() {
        5.times { recipeService.save(new Recipe()) }

        def pageQuery = new PageQuery(size: 2)

        assert recipeService.findByQuery(pageQuery).size() == 2
    }

    @Test
    public void findByQueryWithTag() {
        2.times { recipeService.save(new Recipe().withTags("tag1")) }
        2.times { recipeService.save(new Recipe().withTags("tag2")) }
        recipeService.save(new Recipe().withTags("tag3"))

        def pageQuery = new PageQuery(tag: "tag1")

        assert recipeService.findByQuery(pageQuery).size() == 2
    }

    @Test
    public void findAllTags() {
        recipeService.save(new Recipe().withTags("tag1", "tag2"))
        recipeService.save(new Recipe().withTags("tag2", "tag3"))

        assert asList("tag1", "tag2", "tag3") == recipeService.findAllTags()
    }
}