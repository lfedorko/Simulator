package src.validator;

import src.ValidException;

public class ParseObjects {
    private String line;

    public String[] parseString(String str) throws ValidException {
        String[] result = str.split("\\s");

        if (result.length != 5)
            throw (new ValidException("Invalid number of elements in string!"));
        checkType(result[0]);
        checkLO(Integer.parseInt(result[2]), result[0], result[1]);
        checkLA(Integer.parseInt(result[3]), result[0], result[1]);
        checkHE(Integer.parseInt(result[4]), result[0], result[1]);
        return result;
    }

    private void checkLA(int latitude, String type, String name) throws ValidException {
        if (latitude < 0)
            throw (new ValidException("Latitude " + type + " " + name + " is invalid!"));
    }

    private void checkHE(int height, String type, String name) throws ValidException {
        if (height > 100 || height < 0)
            throw (new ValidException("Height " + type + " " + name + " is invalid!"));
    }

    private void checkLO(int longitude, String type, String name) throws ValidException {
        if (longitude < 0)
            throw (new ValidException("Longitude of " + type + " " + name + " is invalid!"));
    }

    public void checkType(String type) throws ValidException {
        if (!type.equals("Baloon") && !type.equals("Helicopter") && !type.equals("JetPlane"))
            throw (new ValidException("Invalid type of aircraft!"));
    }
}

