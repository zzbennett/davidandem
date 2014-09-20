package models;

import java.util.*;
import javax.persistence.*;

import play.Logger;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * User entity managed by Ebean
 */
@Entity
@Table(name="account")
public class User extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    public String username;

    @Constraints.Required
    public String password;

    // -- Queries

    public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);

    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from username.
     */
    public static User findByUsername(String username) {
        return find.where().eq("username", username).findUnique();
    }

    /**
     * Authenticate a User.
     */
    public static User authenticate(String username, String password) {
        Logger.info(String.format("authenticating: username(%s) and password(%s)", username, password));
        return find.where()
                .eq("username", username)
                .eq("password", password)
                .findUnique();
    }

    // --

    public String toString() {
        return "User(" + username + ") Password("+password+")";
    }

}

