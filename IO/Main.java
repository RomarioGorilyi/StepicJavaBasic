package IO;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 19.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        convertEndOfLineFromWindowsToUnixSystem();
        calculateSumOfNumbers();
    }

    public static int calculateCheckSumOfStream(InputStream inputStream) throws IOException {
        int checkSum = 0;
        int number = inputStream.read();
        while (number != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ number;
            number = inputStream.read();
        }

        return checkSum;
    }

    public static String readAsStringWithCharset(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int inputChar;
        while ((inputChar = reader.read()) != -1) {
            stringBuilder.append((char) inputChar);
        }

        return stringBuilder.toString();
    }

    public static void convertEndOfLineFromWindowsToUnixSystem() {
        ArrayList<Integer> list = new ArrayList<>();

        try (
                BufferedInputStream inputStream = new BufferedInputStream(System.in);
                BufferedOutputStream outputStream = new BufferedOutputStream(System.out)
        ) {
            int inputChar = inputStream.read();
            boolean ifCarriageReturnFound = false;

            while (inputChar != -1) {
                if (inputChar == 13) {
                    ifCarriageReturnFound = true;
                } else if (ifCarriageReturnFound && (inputChar == 10)) {
                    list.remove(list.size() - 1);
                    ifCarriageReturnFound = false;
                } else {
                    ifCarriageReturnFound = false;
                }
                list.add(inputChar);
                inputChar = inputStream.read();
            }


            byte[] output = new byte[list.size()];
            for (int i = 0; i < output.length; i++) {
                output[i] = list.get(i).byteValue();
            }
            outputStream.write(output);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.flush();
    }

    public static void calculateSumOfNumbers() {
        double sum = 0;

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String lineOfData;
            while ((lineOfData = reader.readLine()) != null) {
                String[] lineData = lineOfData.split(" ");
                for (String data : lineData) {
                    try {
                        sum += Double.parseDouble(data);
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                    }
                }
            }

            String result = String.format("%.6f", sum);
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize array of <code>Animal</code> instances.
     *
     * @param data array which is comprised of a quantity of serialized <code>Animal</code> instances
     *             and the very animals
     * @return array of <code>Animal</code> instances
     */
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            int animalsNumber = objectInputStream.readInt();
            animals = new Animal[animalsNumber];
            for (int i = 0; i < animalsNumber; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }
}
