package controllers;

import models.Guest;
import models.TodoItem;
import models.User;
import play.*;
import play.api.templates.Html;
import play.data.Form;
import play.mvc.*;

import scala.Array;
import scala.collection.immutable.List;
import scala.collection.immutable.Seq;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.StringBuilder;
import views.html.*;

import java.util.ArrayList;

public class Application extends Controller {

    // -- Authentication

    public static class Login {

        public String username;
        public String password;

        public String validate() {
            if(User.authenticate(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    public static Result login() {
        return ok(
                login.render(Form.form(Login.class))
        );
    }

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Application.login()
        );
    }

    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("username", loginForm.get().username);
            return redirect(
                    routes.Main.index()
            );
        }
    }
}
