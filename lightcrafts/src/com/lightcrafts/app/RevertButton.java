/* Copyright (C) 2005-2011 Fabio Riccardi */

package com.lightcrafts.app;

import static com.lightcrafts.app.Locale.LOCALE;
import com.lightcrafts.ui.editor.Document;
import com.lightcrafts.ui.editor.EditorMode;
import com.lightcrafts.ui.toolkit.IconFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

final class RevertButton extends EditorButton
    implements PropertyChangeListener {

    private final static Icon Icon =
        IconFactory.createInvertedIcon(RevertButton.class, "revert.png");

    private final static String ToolTip = LOCALE.get("RevertButtonToolTip");

    private Document doc;

    RevertButton(final ComboFrame frame) {
        super(frame, Icon);
        setToolTipText(ToolTip);
        setEnabled(false);

        addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    frame.getEditor().setMode( EditorMode.ARROW );
                    Application.reOpen(frame);
                }
            }
        );
    }

    void updateButton() {
        ComboFrame frame = getComboFrame();
        Document newDoc = frame.getDocument();
        if (newDoc == doc) {
            return;
        }
        if (doc != null) {
            Action action = doc.getUndoAction();
            action.removePropertyChangeListener(this);
        }
        doc = newDoc;
        if (doc != null) {
            Action action = doc.getUndoAction();
            action.addPropertyChangeListener(this);
            setEnabled(action.isEnabled());
        }
        else {
            setEnabled(false);
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Action action = (Action) evt.getSource();
        setEnabled(action.isEnabled());
    }
}
