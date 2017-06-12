package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.instructions.AbstractSyscall;

import javax.swing.*;

/*
Copyright (c) 2003-2008,  Pete Sanderson and Kenneth Vollmar

Developed by Pete Sanderson (psanderson@otterbein.edu)
and Kenneth Vollmar (kenvollmar@missouristate.edu)

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
"Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject 
to the following conditions:

The above copyright notice and this permission notice shall be 
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

(MIT license, http://www.opensource.org/licenses/mit-license.html)
 */

/**
 * Service to display a message to user.<br>
 * <p>
 * Service Number: 55, Name: MessageDialog<br>
 * <p>
 * Input arguments:<br>
 * a0 = address of null-terminated string that is the message to user<br>
 * a1 = the type of the message to the user, which is one of:<br>
 * 1: error message       <br>
 * 2: information message <br>
 * 3: warning message     <br>
 * 4: question message    <br>
 * other: plain message   <br>
 * Output: none
 */

public class SyscallMessageDialog extends AbstractSyscall {
    public SyscallMessageDialog() {
        super(55, "MessageDialog");
    }

    public void simulate(ProgramStatement statement) throws ProcessingException {
        // Display the dialog.
        int msgType = RegisterFile.getValue("a1");
        if (msgType < 0 || msgType > 3)
            msgType = -1; // See values in http://java.sun.com/j2se/1.5.0/docs/api/constant-values.html
        JOptionPane.showMessageDialog(null, NullString.get(statement), null, msgType);
    }
}
