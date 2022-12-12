package Fernbedienung;

import Befehle.*;

import java.util.ArrayList;
import java.util.Stack;

public class Fernbdienung
{
    private ICommand[] einBefehle = new ICommand[8];
    private ICommand[] ausBefehle = new ICommand[8];

    private Stack<ICommand> undoStack = new Stack<ICommand>();
    private Stack<ICommand> redoStack = new Stack<ICommand>();

    public Fernbdienung()
    {
        for (int i = 0; i < 7; i++)
        {
            einBefehle[i] = new KeinCommand();
            ausBefehle[i] = new KeinCommand();
        }
    }

    public void setEinBefehl(ICommand befehl, int pos)
    {
        einBefehle[pos] = befehl;
    }

    public void setAusBefehl(ICommand befehl, int pos) {
        ausBefehle[pos] = befehl;
    }

    public void setAusBefehle(ICommand[] ausBefehle) {
        this.ausBefehle = ausBefehle;
    }

    public void setEinBefehle(ICommand[] einBefehle) {
        this.einBefehle = einBefehle;
    }

    public ICommand[] getAusBefehle() {
        return ausBefehle;
    }

    public ICommand[] getEinBefehle() {
        return einBefehle;
    }

    public ICommand getEinBefehl(int pos)
    {
        return einBefehle[pos];
    }

    public ICommand getAusBefehl(int pos)
    {
        return ausBefehle[pos];
    }

    public Stack<ICommand> getRedoStack() {
        return redoStack;
    }

    public void setRedoStack(Stack<ICommand> redoStack) {
        this.redoStack = redoStack;
    }

    public Stack<ICommand> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<ICommand> undoStack) {
        this.undoStack = undoStack;
    }

    public void commandAusfuehren(boolean einaus, int pos)
    {
        if (einaus)
        {
            this.einBefehle[pos].execute();
            this.undoStack.push(this.einBefehle[pos]);
        }
        else {
            this.ausBefehle[pos].execute();
            this.undoStack.push(this.ausBefehle[pos]);
        }
    }

    public void undoButton()
    {
        if (!undoStack.empty())
        {
            var current = undoStack.peek();
            current.undo();
            undoStack.pop();
            redoStack.push(current);
        }
    }

    public void redoButton()
    {
        if (!redoStack.empty())
        {
            var current = redoStack.peek();
            current.execute();
            redoStack.pop();
            undoStack.push(current);
        }
    }
}
