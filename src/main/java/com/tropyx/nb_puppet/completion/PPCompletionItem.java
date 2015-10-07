
package com.tropyx.nb_puppet.completion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

public class PPCompletionItem implements CompletionItem {
    private final String prefix;
    private final String value;
    private final int caretOffset;
    private final String rightText;
    
    @StaticResource
    private static final String ICON = "com/tropyx/nb_puppet/resources/puppet_icon.gif";

    public PPCompletionItem(String prefix, String value, int caretOffset, String rightText) {
        this.prefix = prefix;
        this.value = value;
        this.caretOffset = caretOffset;
        this.rightText = rightText;
    }
    public PPCompletionItem(String prefix, String value, int caretOffset) {
        this(prefix, value, caretOffset, "");
    }
    

    @Override
    public void defaultAction(JTextComponent component) {
        try {
            component.getDocument().insertString(caretOffset, value.substring(prefix.length()), null);
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void processKeyEvent(KeyEvent evt) {
    }

    @Override
    public int getPreferredWidth(Graphics g, Font defaultFont) {
        return CompletionUtilities.getPreferredWidth(value, rightText, g, defaultFont);
    }

    @Override
    public void render(Graphics g, Font defaultFont, Color defaultColor, Color backgroundColor, int width, int height, boolean selected) {
        CompletionUtilities.renderHtml(ImageUtilities.loadImageIcon(ICON, true), value, rightText, g, defaultFont, defaultColor, width, height, selected);
    }

    @Override
    public CompletionTask createDocumentationTask() {
        return null;
    }

    @Override
    public CompletionTask createToolTipTask() {
        return null;
    }

    @Override
    public boolean instantSubstitution(JTextComponent component) {
        return false;
    }

    @Override
    public int getSortPriority() {
        return 0;
    }

    @Override
    public CharSequence getSortText() {
        return value;
    }

    @Override
    public CharSequence getInsertPrefix() {
        return prefix;
    }

}