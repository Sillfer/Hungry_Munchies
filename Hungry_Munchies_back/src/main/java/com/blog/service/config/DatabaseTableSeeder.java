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
            postService.save(new Post("Chicken Alfredo Pasta", "This creamy and savory pasta dish is a classic that everyone loves. It's quick and easy to make and perfect for any weeknight dinner.", author1, "https://source.unsplash.com/1600x900/?food", "1 lb. fettuccine pasta\n2 boneless, skinless chicken breasts, sliced\n2 cloves garlic, minced\n1/2 cup heavy cream\n1/2 cup grated Parmesan cheese\n1/4 cup chopped fresh parsley\nSalt and pepper to taste",
                    "1. Cook pasta according to package directions. Drain and set aside.\n" +
                            "2. Meanwhile, heat olive oil in a large skillet over medium heat. Add chicken and cook until no longer pink, about 5 minutes. Add garlic and cook for 1 minute.\n" +
                            "3. Stir in cream, Parmesan cheese, parsley, salt and pepper. Cook until heated through, about 2 minutes.\n" +
                            "4. Add pasta to chicken mixture and toss to coat. Serve immediately."));
            postService.save(new Post("Classic Chocolate Chip Cookies", "These classic chocolate chip cookies are crispy on the edges, chewy in the middle, and loaded with chocolate chips. They're perfect with a glass of milk or a cup of tea.", author1, "https://source.unsplash.com/1600x900/?food", "1 cup unsalted butter, softened\n1 cup granulated sugar\n1 cup brown sugar, packed\n2 large eggs\n2 teaspoons vanilla extract\n3 cups all-purpose flour\n1 teaspoon baking soda\n1/2 teaspoon salt\n2 cups semisweet chocolate chips\n1 cup chopped walnuts (optional)",
                    "1. Preheat oven to 375 degrees F (190 degrees C). Line baking sheets with parchment paper.\n" +
                            "2. In a large bowl, cream together the butter, granulated sugar, and brown sugar until light and fluffy. Beat in the eggs one at a time, then stir in the vanilla extract.\n" +
                            "3. In a separate bowl, whisk together the flour, baking soda, and salt. Gradually mix the dry ingredients into the butter mixture.\n" +
                            "4. Stir in the chocolate chips and walnuts, if using.\n" +
                            "5. Scoop the dough into balls and place them on the prepared baking sheets.\n" +
                            "6. Bake for 10-12 minutes, or until the edges are golden brown. Allow to cool on the baking sheet for 5 minutes before transferring to a wire rack to cool completely.\n" +
                            "7. Enjoy with a glass of milk or a cup of tea!"));
            postService.save(new Post("Tomato and Basil Pasta",
                    "A simple yet delicious pasta dish with a classic combination of tomato and basil.",
                    author1,
                    "https://source.unsplash.com/1600x900/?food",
                    "8 oz pasta\n2 tbsp olive oil\n1 onion, chopped\n2 garlic cloves, minced\n1 can diced tomatoes\n1/4 cup chopped fresh basil\nSalt and pepper to taste",
                    "1. Cook the pasta according to package instructions until al dente. Drain and set aside.\n2. Heat the olive oil in a large skillet over medium heat. Add the onion and garlic and cook until softened, about 5 minutes.\n3. Add the can of diced tomatoes, including the juice, and bring to a simmer. Cook for 10-15 minutes until the sauce has thickened slightly.\n4. Stir in the chopped basil and season with salt and pepper to taste.\n5. Add the cooked pasta to the sauce and toss to combine. Serve hot."));
            Author author2 = authorService.getAuthor(2L);
            postService.save(new Post("Spaghetti Bolognese", "Spaghetti bolognese is a classic Italian dish made with ground beef, tomato sauce, and spaghetti.", author2, "https://source.unsplash.com/1600x900/?food", "1 lb. ground beef, 1 onion, 2 cloves garlic, 1 can diced tomatoes, 1 can tomato sauce, 1 tsp. dried oregano, 1 tsp. dried basil, 1 lb. spaghetti, salt and pepper to taste",
                    "1. Cook the spaghetti according to package instructions. \n2. Heat a large skillet over medium-high heat. \n3. Add the ground beef and cook until browned, breaking it up into small pieces as it cooks. \n4. Add the onion and garlic and cook until softened. \n5. Add the diced tomatoes, tomato sauce, oregano, basil, salt, and pepper. \n6. Simmer for 20-30 minutes until the sauce has thickened. \n7. Serve the sauce over the spaghetti."));
            postService.save(new Post("Chicken Parmesan", "Chicken parmesan is a classic Italian-American dish made with chicken cutlets, tomato sauce, and mozzarella cheese.", author2, "https://source.unsplash.com/1600x900/?food", "2 chicken breasts, 1 egg, 1 cup breadcrumbs, 1/2 cup grated Parmesan cheese, 1/2 cup all-purpose flour, 1/2 tsp. salt, 1/2 tsp. pepper, 1/2 cup olive oil, 1 cup tomato sauce, 1/2 cup mozzarella cheese, 1/4 cup grated Parmesan cheese",
                    "1. Preheat oven to 400 degrees F (200 degrees C). \n2. Pound the chicken breasts to 1/4 inch thickness. \n3. In a shallow dish, beat the egg. In another shallow dish, mix together the breadcrumbs and 1/2 cup Parmesan cheese. \n4. In a third shallow dish, mix together the flour, salt, and pepper. \n5. Dip the chicken into the flour mixture, then the egg, and finally the breadcrumb mixture. \n6. Heat the olive oil in a large skillet over medium-high heat. \n7. Add the chicken and cook until golden brown on both sides, about 3 minutes per side. \n8. Transfer the chicken to a baking dish. \n9. Top each chicken breast with tomato sauce and mozzarella cheese. \n10. Sprinkle with the remaining 1/4 cup Parmesan cheese. \n11. Bake in the preheated oven until the cheese is melted and bubbly, about 10 minutes."));
            postService.save(new Post("Grilled Cheese Sandwich", "A grilled cheese sandwich is a simple yet delicious sandwich made with butter, cheese, and bread.", author2, "https://source.unsplash.com/1600x900/?food", "2 slices bread, 1 tbsp. butter, 1 slice cheese",
                    "1. Heat a skillet over medium heat. \n2. Butter one side of each slice of bread. \n3. Place one slice of bread, butter-side down, into the skillet. \n4. Top with cheese and the other slice of bread, butter-side up. \n5. Cook until golden brown on the bottom, about 2 minutes. \n6. Flip and cook until the other side is golden brown, about 2 minutes longer. \n7. Serve immediately."));
            Author author3 = authorService.getAuthor(3L);
            postService.save(new Post("Chocolate Cake", "A classic chocolate cake recipe made with butter, sugar, eggs, and cocoa powder.", author3, "https://source.unsplash.com/1600x900/?food", "1 cup butter, 2 cups sugar, 4 eggs, 1 cup milk, 2 cups flour, 3/4 cup cocoa powder, 1 tsp. baking soda, 1 tsp. salt",
                    "1. Preheat oven to 350 degrees F (175 degrees C). Grease and flour two 9 inch round pans. \n2. In a large bowl, cream together the butter and sugar until smooth. \n3. Beat in the eggs one at a time, then stir in the milk. \n4. In a separate bowl, stir together the flour, cocoa, baking soda, and salt. \n5. Stir the dry ingredients into the batter until just blended. \n6. Pour batter into prepared pans. \n7. Bake in the preheated oven for 30 to 35 minutes, or until a toothpick inserted into the center of the cake comes out clean. \n8. Allow to cool in the pans for 10 minutes, then turn out onto a wire rack and cool completely."));
            postService.save(new Post("Chocolate Chip Cookies", "A classic chocolate chip cookie recipe made with butter, sugar, eggs, and chocolate chips.", author3, "https://source.unsplash.com/1600x900/?food", "1 cup butter, 1 cup white sugar, 1 cup packed brown sugar, 2 eggs, 2 teaspoons vanilla extract, 3 cups all-purpose flour, 1 teaspoon baking soda, 2 teaspoons hot water, 1/2 teaspoon salt, 2 cups semisweet chocolate chips, 1 cup chopped walnuts (optional)",
                    "1. Preheat oven to 350 degrees F (175 degrees C). \n2. Cream together the butter, white sugar, and brown sugar until smooth. \n3. Beat in the eggs one at a time, then stir in the vanilla. \n4. Dissolve baking soda in hot water. \n5. Add to batter along with salt. \n6. Stir in flour, chocolate chips, and nuts. \n7. Drop by large spoonfuls onto ungreased pans. \n8. Bake for about 10 minutes in the preheated oven, or until edges are nicely browned."));
            postService.save(new Post("Chocolate Milkshake", "A classic chocolate milkshake made with milk, chocolate ice cream, and chocolate syrup.", author3, "https://source.unsplash.com/1600x900/?food", "2 scoops chocolate ice cream, 1 cup milk, 2 tbsp. chocolate syrup",
                    "1. Place the ice cream, milk, and chocolate syrup in a blender. \n2. Blend until smooth. \n3. Pour into glasses and serve."));
            Author author4 = authorService.getAuthor(4L);
            postService.save(new Post("Pancakes", "A classic pancake recipe made with flour, eggs, milk, and butter.", author4, "https://source.unsplash.com/1600x900/?food", "1 cup all-purpose flour, 3 teaspoons baking powder, 1 teaspoon salt, 1 tablespoon white sugar, 1 egg, 1 cup milk, 3 tablespoons butter, melted",
                    "1. In a large bowl, sift together the flour, baking powder, salt and sugar. \n2. Make a well in the center and pour in the egg, milk and melted butter; mix until smooth. \n3. Heat a lightly oiled griddle or frying pan over medium high heat. \n4. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. \n5. Brown on both sides and serve hot."));
            postService.save(new Post("French Toast", "A classic French toast recipe made with bread, eggs, milk, and butter.", author4, "https://source.unsplash.com/1600x900/?food", "4 slices white bread, 2 eggs, 1/2 cup milk, 1/4 teaspoon ground cinnamon, 1/4 teaspoon ground nutmeg, 1/4 teaspoon salt, 1 tablespoon butter",
                    "1. In a shallow bowl, beat together the eggs, milk, cinnamon, nutmeg and salt. \n2. Heat a lightly oiled griddle or frying pan over medium high heat. \n3. Dip each slice of bread into the egg mixture, turning to coat both sides. \n4. Place on the hot griddle, and cook until golden brown on both sides. \n5. Serve hot."));
        }
    }
}
