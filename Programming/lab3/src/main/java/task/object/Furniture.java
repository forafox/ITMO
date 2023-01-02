package task.object;
import task.persons.*;
import task.persons.Character;

public abstract class Furniture implements Moveable {
    public static int bookCount=0;
    private Books[] books;
    private final String name;
    public Furniture(){
        name="Объект мебели";
    }
    public Furniture(String name){
        this.name = name;
    }

    public String getContent() {  //выводим список книг объекта
        var result = new StringBuilder();
        for (var book: books) {
            result.append(book.getNameBook()).append(", ");
            this.plusBookCount(1);
            //Znayka.plusBookCount(1);
        }
        return String.format("На и даже под объектом %s лежат книги: "+result.substring(0,result.length() - 2),this.name);
    }
    private void plusBookCount(int i) {
        bookCount=getBookCount()+i;
    }
    private void setBookCount(int count) {
        bookCount=count;
    }
    private int getBookCount() {
        return bookCount;
    }
    public void setBooks(Books[] books) {
        this.books = books;
    } //Присваем список книг объекту

    public String getName(){
        return this.name;
    }

    @Override
    public void move(Character a, Place b){
        b.addObjectOnPlace(this.name);
    }

}
