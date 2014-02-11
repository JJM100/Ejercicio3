package com.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberDocument  extends PlainDocument{

    private static final long serialVersionUID = 3688506575966778420L;
    private int max;
    
    public NumberDocument(){
        super();
    }
    
    public NumberDocument(int max){
        super();
        this.max=max;
    }
  
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        char[] chars = str.toCharArray();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                string.append(chars[i]);
            }
        }
        if (string.length() > 0 && (getLength() + str.length()) <= max) {
            super.insertString(offs, string.toString(), a);
        }
    }
}
