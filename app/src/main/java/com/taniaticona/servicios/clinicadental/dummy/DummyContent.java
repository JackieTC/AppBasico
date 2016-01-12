package com.taniaticona.servicios.clinicadental.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Servicio  " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        //builder.append("Detalles del Servicio : ").append(position);
        for (int i = 0; i < position; i++) {
           switch (i) {
               case 0 :
                   builder.setLength(0);
                builder.append("\nCuraciones dentales. Curaciones dentales con resina estéticas reemplazan amalgamas para prevenir caries en los dientes: incrustacion dental, inlay, onlay y restauracion ceramica. .");
                break;
               case 1 :
                   builder.setLength(0);
                   builder.append("\nSonrisa Perfecta. ¿Quieres conseguir una \"Sonrisa Perfecta\"? ✓ Te enseñamos sus puntos clave y cómo conseguirla. ✓ ¡Entra y entérate! .");
                   break ;
               case 2 :
                   builder.setLength(0);
                   builder.append("\nExtracciones dentales.  Una extracción significa quitar un diente, por lo general a causa de alguna enfermedad o traumatismo o porque hay dientes amontonados.");
                   break;
               case 3 :
                   builder.setLength(0);
                   builder.append("\nImplantes dentales. Recupere la sonrisa con implantes dentales en clínicas Vitaldent. Consulte precios y planes de ahorro de implantes dentales.");
                   break;
               case 4 :
                   builder.setLength(0);
                   builder.append("\nBrackets dentales. Los brackets y la ortodoncia se utilizan para corregir la \"mordedura deficiente\" u oclusión dental defectuosa (cuando los dientes están amontonados o torcidos)");
                   break;
               case 5 :
                   builder.setLength(0);
                   builder.append("\nBlanqueamiento dental. El blanqueamiento dental es un tratamiento dental estético revolucionario que logra reducir varios tonos el color original de las piezas dentales, dejando los dientes más blancos y brillantes.");
                   break;
           }

        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
