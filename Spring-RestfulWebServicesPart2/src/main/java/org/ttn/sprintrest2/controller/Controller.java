package org.ttn.sprintrest2.controller;

/*
    Internationalization
        Add support for Internationalization in your application allowing messages to be shown in English, German and Swedish, keeping English as default.
        Create a GET request which takes "username" as param and shows a localized message "Hello Username". (Use parameters in message properties)

    Content Negotiation
       3. Create POST Method to create user details which can accept XML for user creation.
       4. Create GET Method to fetch the list of users in XML format.

    Swagger
        5. Configure swagger plugin and create document of following methods:
             Get details of User using GET request.
             Save details of the user using POST request.
             Delete a user using DELETE request.
        7. In swagger documentation, add the description of each class and URI so that in swagger UI the purpose of class                  and URI is clear.

    Static and Dynamic filtering
         8. Create API which saves details of User (along with the password) but on successfully saving returns only non-critical data. (Use static filtering)
         9. Create another API that does the same by using Dynamic Filtering.

    Versioning Restful APIs
        10. Create 2 API for showing user details. The first api should return only basic details of the user and the other API should return more/enhanced details of the user,

    Now apply versioning using the following methods:
        MimeType Versioning
        Request Parameter versioning
        URI versioning
        Custom Header Versioning

    HATEOAS
         11. Configure hateoas with your SpringBoot application. Create an api which returns User Details along with url to show all topics.
*/

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import org.ttn.sprintrest2.entity.User;
import org.ttn.sprintrest2.entity.UserV1;
import org.ttn.sprintrest2.entity.UserV2;
import org.ttn.sprintrest2.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class Controller {

    /*
         MessageSource:
            Strategy interface for resolving messages, with support for the parameterization and internationalization of such messages.
                Spring provides two out-of-the-box implementations for production:
                    ResourceBundleMessageSource: built on top of the standard ResourceBundle, sharing its limitations.
                    ReloadableResourceBundleMessageSource: highly configurable, in particular with respect to reloading message definitions.
    */
    @Autowired
    MessageSource messageSource;

    /*
        AUTOWIRED UserService class so that spring able to perform dependency injection and make connection
        and we can easily call any method of that class.
    */
    @Autowired
    UserService userService;

    /*
        API For Create a GET request which takes "username" as param and shows a localized message "Hello Username".
        (Use parameters in message properties)
    */
    @RequestMapping(method = RequestMethod.GET, path = "/welcome/{username}")
    public String welcome(@PathVariable String username) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("welcome.message", null, "Default message", locale) + username;
    }

    //API for finding all the user
    @ApiOperation(value = "Return list of users", response = User.class)
    @RequestMapping(method = RequestMethod.GET, path = "/get", produces = "application/xml")
    public List<User> getUser() {
        List<User> emp = new ArrayList<>();
        for (User employee : userService.getUsers()) {
            Link link = linkTo(Controller.class)
                    .slash(employee.getId()).withSelfRel();

            employee.add(link);

            Link reportLink = linkTo(methodOn(Controller.class)
                    .deleteUser(employee.getId()))
                    .withRel("report");

            employee.add(reportLink);
            emp.add(employee);
        }
        return emp;
    }

    //API for adding the user which consume XML request and return JSON request as well
    @ApiOperation(value = "Add New User")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "User Not created")})
    @PostMapping(path = "/add", consumes = "application/xml", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    //API for adding the user which consume JSON request and return JSON request as well
    @RequestMapping(method = RequestMethod.POST, path = "/add", consumes = "application/json", produces = "application/json")
    public User addUserJson(@RequestBody User user) {
        return userService.addUser(user);
    }

    //API for deleting a user according to the userID
    @ApiOperation(value = "Delete user by Id")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "User Not Found")})
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}", produces = "application/xml")
    public User deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    //URI Versioning ~ Return the full name of the USER
    @RequestMapping(method = RequestMethod.GET, path = "v1/user", produces = "application/json")
    public UserV1 getUser1() {
        return userService.getUser1();
    }

    //URI Versioning ~ Return the firstName and lastName of the USER
    @RequestMapping(method = RequestMethod.GET, path = "v2/user", produces = "application/json")
    public UserV2 getUser2() {
        return userService.getUser2();
    }

    //Request Parameter versioning - URI Versioning ~ Return the full name of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", params = "version=1", produces = "application/json")
    public UserV1 getUserParameter1() {
        return userService.getUser1();
    }

    //Request Parameter versioning - URI Versioning ~ Return the firstName and lastName of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", params = "version=2", produces = "application/json")
    public UserV2 getUserParameter2() {
        return userService.getUser2();
    }


    // Headers versioning - URI Versioning ~ Return the full name of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", headers = "X-API-VERSION=1", produces = "application/json")
    public UserV1 getUserHeadedV1() {
        return userService.getUser1();
    }

    // Headers versioning - URI Versioning ~ Return the firstName and lastName of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", headers = "X-API-VERSION=2", produces = "application/json")
    public UserV2 getUserHeaderV2() {
        return userService.getUser2();
    }

    //Mime type versioning - URI Versioning ~ Return the full name of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", produces = "application/vnd.company.app-v1+json")
    public UserV1 getUserMediaTypeV1() {
        return userService.getUser1();
    }

    //Mime type versioning - URI Versioning ~ Return the firstName and lastName of the USER
    @RequestMapping(method = RequestMethod.GET, path = "user", produces = "application/vnd.company.app-v2+json")
    public UserV2 getUserMediaTypeV2() {
        return userService.getUser2();
    }
}
