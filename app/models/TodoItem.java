package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;
import scala.collection.immutable.List;

import javax.persistence.*;

@Entity
public class TodoItem extends Model {

    public TodoItem(Long id, String label) {
        super();
        this.id = id;
        this.label = label;
    }

    @Id
    public Long id;

    @Constraints.Required
    public String label;

    public static Finder<Long, TodoItem> find = new Model.Finder(
            Long.class, TodoItem.class
    );

    public static java.util.List<TodoItem> all() {
        return find.all();
    }

    public static void create(TodoItem todoItem) {
        todoItem.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}
