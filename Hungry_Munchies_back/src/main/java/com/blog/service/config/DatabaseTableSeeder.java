package com.blog.service.config;

import com.blog.model.*;
import com.blog.service.AuthorService;
import com.blog.service.PostService;
import com.blog.service.RoleService;
import com.blog.service.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DatabaseTableSeeder implements CommandLineRunner {
    public static Faker faker = new Faker();
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        initTables();
    }

    private void initTables() {
        if (roleService.isEmpty()) {
            roleService.save(new Role(ERole.ROLE_ADMIN));
            roleService.save(new Role(ERole.ROLE_MODERATOR));
            roleService.save(new Role(ERole.ROLE_USER));
        }

        if (authorService.isEmpty()) {
            authorService.save(new Author("Chef 1", "Moroccan cuisine", "Expert in Moroccan cuisine with 10 years experience & culinary arts degree."));
            authorService.save(new Author("Chef 2", "French cuisine", "Expert in French cuisine with 10 years experience & culinary arts degree."));
            authorService.save(new Author("Chef 3", "Italian cuisine", "Expert in Italian cuisine with 10 years experience & culinary arts degree."));
            authorService.save(new Author("Chef 4", "Spanish cuisine", "Expert in Spanish cuisine with 10 years experience & culinary arts degree."));
        }

        if (userService.isEmpty()) {
            Set<Role> rolesAdmin = new HashSet<>();
            Role adminRole = roleService.findByName(ERole.ROLE_ADMIN);
            rolesAdmin.add(adminRole);
            userService.create(new User("admin", "admin@email.com", "12345678", rolesAdmin, null));

            Set<Role> rolesMod = new HashSet<>();
            Role modRole = roleService.findByName(ERole.ROLE_MODERATOR);
            rolesMod.add(modRole);
            userService.create(new User("mod", "mod@email.com", "12345678", rolesMod, null));

            Set<Role> rolesUser = new HashSet<>();
            Role userRole = roleService.findByName(ERole.ROLE_USER);
            rolesUser.add(userRole);
            Author author1 = authorService.findByName("Chef 1");
            userService.create(new User("user1", "user1@email.com", "12345678", rolesUser, author1));
            Author author2 = authorService.findByName("Chef 2");
            userService.create(new User("user2", "user2@email.com", "12345678", rolesUser, author2));
            Author author3 = authorService.findByName("Chef 3");
            userService.create(new User("user3", "user3@gmail.com", "12345678", rolesUser, author3));
            Author author4 = authorService.findByName("Chef 4");
            userService.create(new User("user4", "user4@gmail.com", "12345678", rolesUser, author4));
        }


        if (postService.isEmpty()) {
            Author author1 = authorService.getAuthor(1L);
            postService.save(new Post("Chicken Alfredo Pasta", "This creamy and savory pasta dish is a classic that everyone loves. It's quick and easy to make and perfect for any weeknight dinner.", author1, "https://images.unsplash.com/photo-1673081849734-98f0969d436b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80", "1 lb. fettuccine pasta\n2 boneless, skinless chicken breasts, sliced\n2 cloves garlic, minced\n1/2 cup heavy cream\n1/2 cup grated Parmesan cheese\n1/4 cup chopped fresh parsley\nSalt and pepper to taste",
                    " Cook pasta according to package directions. Drain and set aside.\n" +
                            " Meanwhile, heat olive oil in a large skillet over medium heat. Add chicken and cook until no longer pink, about 5 minutes. Add garlic and cook for 1 minute.\n" +
                            " Stir in cream, Parmesan cheese, parsley, salt and pepper. Cook until heated through, about 2 minutes.\n" +
                            " Add pasta to chicken mixture and toss to coat. Serve immediately.", ECategory.MOROCCAN, Status.PUBLISHED));
            postService.save(new Post("Classic Chocolate Chip Cookies", "These classic chocolate chip cookies are crispy on the edges, chewy in the middle, and loaded with chocolate chips. They're perfect with a glass of milk or a cup of tea.", author1, "https://images.unsplash.com/photo-1605243614624-277f48f46d52?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", "1 cup unsalted butter, softened\n1 cup granulated sugar\n1 cup brown sugar, packed\n2 large eggs\n2 teaspoons vanilla extract\n3 cups all-purpose flour\n1 teaspoon baking soda\n1/2 teaspoon salt\n2 cups semisweet chocolate chips\n1 cup chopped walnuts (optional)",
                    " Preheat oven to 375 degrees F (190 degrees C). Line baking sheets with parchment paper.\n" +
                            " In a large bowl, cream together the butter, granulated sugar, and brown sugar until light and fluffy. Beat in the eggs one at a time, then stir in the vanilla extract.\n" +
                            " In a separate bowl, whisk together the flour, baking soda, and salt. Gradually mix the dry ingredients into the butter mixture.\n" +
                            " Stir in the chocolate chips and walnuts, if using.\n" +
                            " Scoop the dough into balls and place them on the prepared baking sheets.\n" +
                            " Bake for 10-12 minutes, or until the edges are golden brown. Allow to cool on the baking sheet for 5 minutes before transferring to a wire rack to cool completely.\n" +
                            " Enjoy with a glass of milk or a cup of tea!", ECategory.MOROCCAN, Status.PENDING));
            postService.save(new Post("Tomato and Basil Pasta",
                    "A simple yet delicious pasta dish with a classic combination of tomato and basil.",
                    author1,
                    "https://plus.unsplash.com/premium_photo-1664478291780-0c67f5fb15e6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80",
                    "8 oz pasta\n2 tbsp olive oil\n1 onion, chopped\n2 garlic cloves, minced\n1 can diced tomatoes\n1/4 cup chopped fresh basil\nSalt and pepper to taste",
                    " Cook the pasta according to package instructions until al dente. Drain and set aside.\n Heat the olive oil in a large skillet over medium heat. Add the onion and garlic and cook until softened, about 5 minutes.\n Add the can of diced tomatoes, including the juice, and bring to a simmer. Cook for 10-15 minutes until the sauce has thickened slightly.\n Stir in the chopped basil and season with salt and pepper to taste.\n Add the cooked pasta to the sauce and toss to combine. Serve hot.", ECategory.ITALIAN, Status.PUBLISHED));
            Author author2 = authorService.getAuthor(2L);
            postService.save(new Post("Spaghetti Bolognese", "Spaghetti bolognese is a classic Italian dish made with ground beef, tomato sauce, and spaghetti.", author2, "https://images.unsplash.com/photo-1598866594230-a7c12756260f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1008&q=80", "1 lb. ground beef, 1 onion, 2 cloves garlic, 1 can diced tomatoes, 1 can tomato sauce, 1 tsp. dried oregano, 1 tsp. dried basil, 1 lb. spaghetti, salt and pepper to taste",
                    " Cook the spaghetti according to package instructions. \n Heat a large skillet over medium-high heat. \n Add the ground beef and cook until browned, breaking it up into small pieces as it cooks. \n4. Add the onion and garlic and cook until softened. \n Add the diced tomatoes, tomato sauce, oregano, basil, salt, and pepper. \n Simmer for 20-30 minutes until the sauce has thickened. \n Serve the sauce over the spaghetti.", ECategory.ITALIAN, Status.PENDING));
            postService.save(new Post("Chicken Parmesan", "Chicken parmesan is a classic Italian-American dish made with chicken cutlets, tomato sauce, and mozzarella cheese.", author2, "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", "2 chicken breasts, 1 egg, 1 cup breadcrumbs, 1/2 cup grated Parmesan cheese, 1/2 cup all-purpose flour, 1/2 tsp. salt, 1/2 tsp. pepper, 1/2 cup olive oil, 1 cup tomato sauce, 1/2 cup mozzarella cheese, 1/4 cup grated Parmesan cheese",
                    " Preheat oven to 400 degrees F (200 degrees C). \n Pound the chicken breasts to 1/4 inch thickness. \n In a shallow dish, beat the egg. In another shallow dish, mix together the breadcrumbs and 1/2 cup Parmesan cheese. \n In a third shallow dish, mix together the flour, salt, and pepper. \n Dip the chicken into the flour mixture, then the egg, and finally the breadcrumb mixture. \n Heat the olive oil in a large skillet over medium-high heat. \n Add the chicken and cook until golden brown on both sides, about 3 minutes per side. \n Transfer the chicken to a baking dish. \n Top each chicken breast with tomato sauce and mozzarella cheese. \n Sprinkle with the remaining 1/4 cup Parmesan cheese. \n Bake in the preheated oven until the cheese is melted and bubbly, about 10 minutes.", ECategory.ITALIAN, Status.PUBLISHED));
            postService.save(new Post("Grilled Cheese Sandwich", "A grilled cheese sandwich is a simple yet delicious sandwich made with butter, cheese, and bread.", author2, "https://images.unsplash.com/photo-1608039858788-667850f129f6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "2 slices bread, 1 tbsp. butter, 1 slice cheese",
                    " Heat a skillet over medium heat. \n Butter one side of each slice of bread. \n Place one slice of bread, butter-side down, into the skillet. \n Top with cheese and the other slice of bread, butter-side up. \n Cook until golden brown on the bottom, about 2 minutes. \n Flip and cook until the other side is golden brown, about 2 minutes longer. \n Serve immediately.", ECategory.ITALIAN, Status.PUBLISHED));
            Author author3 = authorService.getAuthor(3L);
            postService.save(new Post("Chocolate Cake", "A classic chocolate cake recipe made with butter, sugar, eggs, and cocoa powder.", author3, "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "1 cup butter, 2 cups sugar, 4 eggs, 1 cup milk, 2 cups flour, 3/4 cup cocoa powder, 1 tsp. baking soda, 1 tsp. salt",
                    " Preheat oven to 350 degrees F (175 degrees C). Grease and flour two 9 inch round pans. \n In a large bowl, cream together the butter and sugar until smooth. \n Beat in the eggs one at a time, then stir in the milk. \n In a separate bowl, stir together the flour, cocoa, baking soda, and salt. \n Stir the dry ingredients into the batter until just blended. \n Pour batter into prepared pans. \n Bake in the preheated oven for 30 to 35 minutes, or until a toothpick inserted into the center of the cake comes out clean. \n Allow to cool in the pans for 10 minutes, then turn out onto a wire rack and cool completely.", ECategory.FRENCH, Status.PUBLISHED));
            postService.save(new Post("Chocolate Chip Cookies", "A classic chocolate chip cookie recipe made with butter, sugar, eggs, and chocolate chips.", author3, "https://images.unsplash.com/photo-1625876981820-be17a6807189?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80", "1 cup butter, 1 cup white sugar, 1 cup packed brown sugar, 2 eggs, 2 teaspoons vanilla extract, 3 cups all-purpose flour, 1 teaspoon baking soda, 2 teaspoons hot water, 1/2 teaspoon salt, 2 cups semisweet chocolate chips, 1 cup chopped walnuts (optional)",
                    " Preheat oven to 350 degrees F (175 degrees C). \n Cream together the butter, white sugar, and brown sugar until smooth. \n Beat in the eggs one at a time, then stir in the vanilla. \n Dissolve baking soda in hot water. \n Add to batter along with salt. \n Stir in flour, chocolate chips, and nuts. \n Drop by large spoonfuls onto ungreased pans. \n Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.", ECategory.FRENCH, Status.PUBLISHED));
            postService.save(new Post("Chocolate Milkshake", "A classic chocolate milkshake made with milk, chocolate ice cream, and chocolate syrup.", author3, "https://plus.unsplash.com/premium_photo-1663853294230-0e53cddd88c8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "2 scoops chocolate ice cream, 1 cup milk, 2 tbsp. chocolate syrup",
                    " Place the ice cream, milk, and chocolate syrup in a blender. \n Blend until smooth. \n Pour into glasses and serve.", ECategory.FRENCH, Status.PENDING));
            Author author4 = authorService.getAuthor(4L);
            postService.save(new Post("Pancakes", "A classic pancake recipe made with flour, eggs, milk, and butter.", author4, "https://images.unsplash.com/photo-1554520735-0a6b8b6ce8b7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80", "1 cup all-purpose flour, 3 teaspoons baking powder, 1 teaspoon salt, 1 tablespoon white sugar, 1 egg, 1 cup milk, 3 tablespoons butter, melted",
                    " In a large bowl, sift together the flour, baking powder, salt and sugar. \n Make a well in the center and pour in the egg, milk and melted butter; mix until smooth. \n Heat a lightly oiled griddle or frying pan over medium high heat. \n Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. \n Brown on both sides and serve hot.", ECategory.AMERICAN, Status.PUBLISHED));
            postService.save(new Post("French Toast", "A classic French toast recipe made with bread, eggs, milk, and butter.", author4, "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=749&q=80", "4 slices white bread, 2 eggs, 1/2 cup milk, 1/4 teaspoon ground cinnamon, 1/4 teaspoon ground nutmeg, 1/4 teaspoon salt, 1 tablespoon butter",
                    " In a shallow bowl, beat together the eggs, milk, cinnamon, nutmeg and salt. \n Heat a lightly oiled griddle or frying pan over medium high heat. \n Dip each slice of bread into the egg mixture, turning to coat both sides. \n Place on the hot griddle, and cook until golden brown on both sides. \n Serve hot.", ECategory.AMERICAN, Status.PUBLISHED));
        }
    }
}
