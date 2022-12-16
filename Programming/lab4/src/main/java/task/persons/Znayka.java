package task.persons;

public final class Znayka extends Character {

    private static int bookCount=0;
        private static Znayka INSTANCEONE;
        private Znayka() {
            super("Знайка");
        }
        public static Znayka getInstance() {
            if (INSTANCEONE == null) {
                INSTANCEONE = new Znayka();
            }
            return INSTANCEONE;
        }

    public static void setBookCount(int n){
        bookCount+=n;
    }
    public static int getBookCount(){
        return bookCount;
    }


    public String checkShame(){//Проверка стыда. Если книг больше 5, то знайке стыдно
        return (this.getShame() > 3) ? " стыдно " : " не стыдно ";
    }

    public static void PlusBookCount(int count){
            setBookCount(getBookCount()+count);
        }
}
