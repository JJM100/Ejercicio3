package com.classes;

public abstract class NumberToLetterConverter {

    private static final String[] UNIDADES = { "","UNO ", "DOS ", "TRES ",
        "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
        "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
        "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};

    private static final String[] DECENAS = {"VEINTE ", "TREINTA ", "CUARENTA ",
        "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
        "CIEN "};

    private static final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ",
        "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
        "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};

    public static String convertNumberToLetter(int numero) {
        StringBuilder converted = new StringBuilder();
        String splitNumber[] = String.valueOf(numero).split("#");
        determinarNumero(splitNumber, converted, 2);
        return converted.toString();
    }

    private static String convertirNumbero(String numbero) {

        if (numbero.equals("100")) {
            return "CIEN";
        }

        StringBuilder output = new StringBuilder();
        if (getDigitAt(numbero, 2) != 0) {
            output.append(CENTENAS[getDigitAt(numbero, 2) - 1]);
        }

        int k = Integer.parseInt(String.valueOf(getDigitAt(numbero, 1)) + String.valueOf(getDigitAt(numbero, 0)));

        if (k <= 20) {
            output.append(UNIDADES[k-1]);
        } else if (k > 30 && getDigitAt(numbero, 0) != 0) {
            output.append(DECENAS[getDigitAt(numbero, 1) - 2].concat("Y ").concat(UNIDADES[getDigitAt(numbero, 0)]));
        } else {
            output.append(DECENAS[getDigitAt(numbero, 1) - 2].concat(UNIDADES[getDigitAt(numbero, 0)]));
        }

        return output.toString();
    }

    /**
     * Retorna el digito numerico en la posicion indicada de derecha a izquierda
     *
     * @param origin Cadena en la cual se busca el digito
     * @param position Posicion de derecha a izquierda a retornar
     * @return Digito ubicado en la posicion indicada
     */
    private static int getDigitAt(String origin, int position) {
        if (origin.length() > position && position >= 0) {
            return origin.charAt(origin.length() - position - 1) - 48;
        }
        return 0;
    }

    /**
     * Indices para MILLON: 8,7,6
     * Indices para MILES: 5,4,3
     * Indices para CIENTOS: 2,1,0
     * @param splitNumber
     * @param converted
     * @param enumNumber 
     */
    private static void determinarNumero(String[] splitNumber, StringBuilder converted, int indice) {
   
         int numero = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                indice))
                + String.valueOf(getDigitAt(splitNumber[0], (indice-1)))
                + String.valueOf(getDigitAt(splitNumber[0], (indice-2))));
         
        if (numero == 1) {
            converted.append("UNO ");
        } else if (numero > 1) {
            converted.append(convertirNumbero(String.valueOf(numero)));
        }
    }

}
