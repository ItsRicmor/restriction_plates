package com.restriction.model;

public class Plate {

    private String plateNumber;

    public Plate(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public boolean isValidPlate() {
        return isValidLength() && endsInValidNumber();
    }

    private boolean isValidLength() {
        return this.plateNumber.length() == 7;
    }

    private boolean endsInValidNumber() {
        try {
            int number = convertLastDigitToInt();
            return endsNumberInZero(number);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean endsNumberInZero(int number) {
        return number != 0;
    }

    private int convertLastDigitToInt() {
        String theLastDigit = this.getLastDigit();
        return Integer.parseInt(theLastDigit);
    }

    public int getLastDigitOfPlate() {
        return this.convertLastDigitToInt();
    }

    private String getLastDigit() {
        int theLastIndex = this.getLastIndex();
        return getLastCharToString(theLastIndex);
    }

    private String getLastCharToString(int theLastIndex) {
        char theLastDigit = this.plateNumber.charAt(theLastIndex);
        return String.valueOf(theLastDigit);
    }

    private int getLastIndex() {
        return this.plateNumber.length() - 1;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
