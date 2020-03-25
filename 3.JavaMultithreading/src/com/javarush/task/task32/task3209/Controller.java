package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null) {

            document.removeUndoableEditListener(view.getUndoListener());
            document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
            view.update();
        } else {
            document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
            view.update();
        }
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void setPlainText(String text) {
        try {
            resetDocument();
            StringReader stringReader = new StringReader(text);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);

        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {

            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int i = jFileChooser.showOpenDialog(view);
        if(i == jFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)){
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader,document,0);
                view.resetUndo();
            }
            catch (Exception ee){
                ExceptionHandler.log(ee);
            }
        }
    }

    public void saveDocument() {
        try{
            if(currentFile==null){
                saveDocumentAs();
            }
            else{
                view.selectHtmlTab();
                FileWriter fileWriter = new FileWriter(currentFile);
                try {

                    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                    htmlEditorKit.write(fileWriter, document, 0, document.getLength());

                } catch (Exception e) {
                    ExceptionHandler.log(e);
                }
                fileWriter.flush();
                fileWriter.close();
            }
        }
        catch (Exception ee){
            ExceptionHandler.log(ee);

        }

    }

    public void saveDocumentAs() {

        try {
            view.selectHtmlTab();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new HTMLFileFilter());
            int i = jFileChooser.showSaveDialog(view);

            if(i ==jFileChooser.APPROVE_OPTION){
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());
                FileWriter fileWriter = new FileWriter(currentFile);
                try {

                    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                    htmlEditorKit.write(fileWriter, document, 0, document.getLength());

                } catch (Exception e) {
                    ExceptionHandler.log(e);
                }
                fileWriter.close();

            }

        }
        catch (Exception ee){
            ExceptionHandler.log(ee);
        }

    }
}
