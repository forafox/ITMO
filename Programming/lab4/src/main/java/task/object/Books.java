package task.object;

public enum Books {

    WAR_AND_PIECE("Война и мир",0,1000),
    HARRY_POTTER("Гарри Потер",0,800),
    COLORING_BOOK("Раскраска",5,6),
    NOTEBOOK("Записная книжечка",2,8);

    private int clear_paper;
    private int scribbled_paper;
    private String name;

    Books(String name,int clear_paper, int scribbled_paper){
        this.name=name;
        this.clear_paper=clear_paper;
        this.scribbled_paper=scribbled_paper;
    }
    public String getNameBook(){return this.name;}
    public int getClear_paper(){return this.clear_paper ;}
    public int getScribbled_paper(){return this.scribbled_paper ;}
    public void changeClear_paper(int n){
        System.out.println(String.format("Исписано %d чистых страниц",n));
        this.clear_paper = getClear_paper()-n ;}
    public void changeScribbled_paper(int n){
        System.out.println(String.format("Написано %d страниц",n));
        this.scribbled_paper =getScribbled_paper() +n ;}

}
