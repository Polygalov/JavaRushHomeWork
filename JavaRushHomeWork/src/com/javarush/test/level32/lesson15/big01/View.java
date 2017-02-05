package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andy on 05.09.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener()
    {
        return undoListener;
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0;
    }

    public View()
    {
        try {

            // устанавливаем Look And Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }
    public void exit(){
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String command = actionEvent.getActionCommand();
        if (command.equals("Новый")){
            controller.createNewDocument();
        }
       else if (command.equals("Открыть")){
            controller.openDocument();
        }
        else if (command.equals("Сохранить")){
            controller.saveDocument();
        }
        else if (command.equals("Сохранить как...")){
            controller.saveDocumentAs();
        }
        else if (command.equals("Выход")){
            controller.exit();
        }
        else if (command.equals("О программе")){
            this.showAbout();
        }

    }
    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this,menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();

    }
    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        }
        if (tabbedPane.getSelectedIndex()==1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    public void undo(){
        try{
            undoManager.undo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try{
            undoManager.redo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }
    public void resetUndo()
    {
        try{
            undoManager.discardAllEdits();
        }catch (Exception e){ExceptionHandler.log(e);}
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(this,"HTML редактор версия 0.0.1", "About", JOptionPane.INFORMATION_MESSAGE);
    }


}

/*
Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод
наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню, у
которых наше представление указано в виде слушателя событий.
19.1.	Получи из события команду с помощью метода getActionCommand(). Это будет
обычная строка. По этой строке ты можешь понять какой пункт меню создал данное
событие.
19.2.	Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом
пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
19.3.	Если это команда "Открыть", вызови метод openDocument().
19.4.	Если "Сохранить", то вызови saveDocument().
19.5.	Если "Сохранить как..." - saveDocumentAs().
19.6.	Если "Выход" - exit().
19.7.	Если "О программе", то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.
 */