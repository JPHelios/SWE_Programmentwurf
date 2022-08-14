package model.utils;

import util.enums.FontType;
import util.enums.FrameSize;
import util.enums.TextSize;

import java.awt.*;

public class Setting {

    public String FONT = FontType.ARIAL.toString();
    public int FONT_SIZE_SMALL = TextSize.TEXT_SIZE_XLARGE.label();
    public int FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_XLARGE.text();
    public FrameSize frameSize = FrameSize.WINDOW_XLARGE;


    public Setting(){

        /*  Folgende Überlegung:
            Beim Start der App soll zuerst überprüft werden, ob denn bereits ein Dokument mit den Settings existiert
            Wenn das der Fall ist, dann sollen hier in den Settings die Daten aus dem Dokument ausgelesen werden und global
            für das ganze Programm gesetzt werden.

            Ist noch kein File vorhanden, dann sollen einfach die Defaultwerte geladen werden.
            In diesem Fall wären das die Einstellung für einen Standard-Laptopbildschirm, bei uns würd ich da ggf. einfach
            entweder FrameSize.WINDOW_SMALL oder FrameSize.WINDOW_MEDIUM laden.

            Sofern keine Einstellungen geändert werden, soll auch kein Settingsfile geschrieben werden, wozu auch, wenn man
            nur Defaultwerte verwendet.

            Wichitg ist dabei zu beachten, dass wenn ein Settings-File bereits vorhanden ist, es sein kann, dass nicht alle
            Werte vom Anwender geändert wurden, einfach nur ein Reminder, um ggf. Fehler abzufangen.
         */

    }
}
