package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Andy on 05.09.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument()
    {
        return document;
    }

    public Controller(View view)
    {
        this.view = view;
    }
    public void init(){
        createNewDocument();
    }

    public static void main(String[] args)
    {
        View obView = new View();
        Controller controller = new Controller(obView);
        obView.setController(controller);
        obView.init();
        controller.init();

    }
    public void exit(){
        System.exit(0);
    }
    public void resetDocument(){
if (document!=null){
    document.removeUndoableEditListener(view.getUndoListener());
}
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
           ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try
        {
            new HTMLEditorKit().write(writer,document,0,document.getLength());
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }
    public void createNewDocument(){
       view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile=null;
    }
    public void openDocument(){
        //Переключать представление на html вкладку
        view.selectHtmlTab();
        //Создавать новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        //Устанавливать ему в качестве фильтра объект HTMLFileFilter
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showOpenDialog(view);

        //Когда файл выбран, необходимо
        if (n == JFileChooser.APPROVE_OPTION) {
            //Установить новое значение currentFile
            currentFile = jFileChooser.getSelectedFile();
            //Сбросить документ
            resetDocument();
            //Установить имя файла в заголовок у представления
            view.setTitle(currentFile.getName());

            //Создать FileReader, используя currentFile
            try (FileReader fileReader = new FileReader(currentFile)) {
                //Вычитать данные из FileReader-а в документ document с помощью объекта класса
                new HTMLEditorKit().read(fileReader, document, 0);
                //Сбросить правки
                view.resetUndo();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument(){
        if (currentFile == null) {
            saveDocumentAs();
        }
        else {
            //Переключать представление на html вкладку
            view.selectHtmlTab();

            //Создавать FileWriter на базе currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        int n = fileChooser.showSaveDialog(view);
        //Если пользователь подтвердит выбор файла:
        if (n == JFileChooser.APPROVE_OPTION) {
             //Сохранять выбранный файл в поле currentFile
            currentFile = fileChooser.getSelectedFile();
            //Устанавливать имя файла в качестве заголовка окна представления
            view.setTitle(currentFile.getName());

            //Создавать FileWriter на базе currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }
}

/*
23.1.	Напишем метод для сохранения открытого файла saveDocument(). Метод должен
работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а
использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().
23.2.	Пришло время реализовать метод openDocument(). Метод должен работать
аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.
Подсказка: Обрати внимание на имя метода для показа диалогового окна.
Когда файл выбран, необходимо:
23.2.1.	Установить новое значение currentFile.
23.2.2.	Сбросить документ.
23.2.3.	Установить имя файла в заголовок у представления.
23.2.4.	Создать FileReader, используя currentFile.
23.2.5.	Вычитать данные из FileReader-а в документ document с помощью объекта класса
HTMLEditorKit.
23.2.6.	Сбросить правки (вызвать метод resetUndo представления).
23.2.7.	Если возникнут исключения - залогируй их и не пробрасывай наружу.
Проверь работу пунктов меню Сохранить и Открыть.
 */