package controllers;

import models.Guest;
import models.TodoItem;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.guests;
import views.html.index;
import views.html.todo;

@Security.Authenticated(Secured.class)
public class Main extends Controller {

    //TODO: load menu headers from DB
    //TODO: allow menu headers to be edited by admin
    public static final String[] mainMenuHeaders = {
            "pictures",
            "to-do",
            "contacts",
            "guests",
            "announcements"};

    public static Result index() {
        //TODO: require authentication
        //TODO: if signed in (check cookie), skip authentication

        //TODO: if admin is signed in, return admin page
        //      else, return regular page
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
