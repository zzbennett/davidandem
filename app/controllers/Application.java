package controllers;

import models.Guest;
import models.TodoItem;
import play.*;
import play.api.templates.Html;
import play.mvc.*;

import scala.Array;
import scala.collection.immutable.List;
import scala.collection.immutable.Seq;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.StringBuilder;
import views.html.*;

import java.util.ArrayList;

public class Application extends Controller {

    public static final String[] mainMenuHeaders = {
            "pictures",
            "to-do",
            "contacts",
            "guests",
            "announcements"};

    public static Result index() {
        //if signed in (check cookie), skip authentication
        return ok(index.render("David and Emillie's Wedding", play.libs.Scala.toSeq(mainMenuHeaders), mainBody()));
    }

    public static Result todo() {

        String[] tempTodoItems = {
                "pictures",
                "to-do",
                "contacts",
                "guests",
                "announcements"};
        TodoItem[] todoItems = new TodoItem[5];
        for( int i = 0; i < 5; i++ ) {
            todoItems[i] = new TodoItem(new Long(i),tempTodoItems[i]);
        }

        /*
        return ok(todo.render("David and Emillie's Wedding",
                play.libs.Scala.toSeq(mainMenuHeaders),
                play.libs.Scala.toSeq(TodoItem.all())));
                */
        return ok(todo.render("David and Emillie's Wedding",
                play.libs.Scala.toSeq(mainMenuHeaders),
                play.libs.Scala.toSeq(todoItems)));
    }

    public static Result guests() {

        String[] tempGuests = {
                "David",
                "Liz",
                "Courtney",
                "Alex",
                "Paul",
                "Jan"};
        Guest[] guestList = new Guest[tempGuests.length];
        for( int i = 0; i < tempGuests.length; i++ ) {
            guestList[i] = new Guest(new Long(i),tempGuests[i],"");
        }

        /*
        return ok(todo.render("David and Emillie's Wedding",
                play.libs.Scala.toSeq(mainMenuHeaders),
                play.libs.Scala.toSeq(TodoItem.all())));
                */
        return ok(guests.render("David and Emillie's Wedding",
                play.libs.Scala.toSeq(mainMenuHeaders),
                play.libs.Scala.toSeq(guestList)));
    }

    private static String mainBody() {
        String mainBody = "This is the main body of text on the front page";
        for(int i = 0; i<4; i++) {
            mainBody += ". " + mainBody;
        }
        return mainBody;
    }

}
