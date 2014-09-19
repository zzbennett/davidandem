package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;
import scala.collection.immutable.List;

import javax.persistence.*;

@Entity
public class Guest extends Model {

    public Guest(Long id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rsvp = false;
        this.invitationSent = false;
    }

    @Id
    public Long id;

    @Constraints.Required
    public String firstName;
    public String lastName;

    public boolean invitationSent;

    public boolean rsvp;

    public static Finder<Long, Guest> find = new Model.Finder(
            Long.class, Guest.class
    );

    public static java.util.List<Guest> all() {
        return find.all();
    }

    public static void create(Guest todoItem) {
        todoItem.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}

