interface Document {
    void open();
}
class wordDoc implements Document{
    public void open(){
        System.out.println("Opening word Document...");
    }
}
class PdfDoc implements Document{
    public void open(){
        System.out.println("Opening Pdf Document...");
    }
}
class ExcelDoc implements Document{
    public void open(){
        System.out.println("Opening Excel Document...");
    }
}
abstract class DocumentFactory{
    public abstract Document createDocument();
}
class WordFactory extends DocumentFactory{
    public Document createDocument(){
        return new wordDoc();
    }
}
class PdfFactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDoc();
    }
}
class ExcelFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDoc();
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}