public class TestNumbers {

    public static void main(String[] args) {
        System.out.println("Test Numbers");

        HugeInteger hugeInteger = new HugeInteger("99999999999999999999999999999");

        System.out.println("\n\nHuge Integer: \n" +
                hugeInteger.toStringCommaFormat());

        HugeInteger secondHugeInteger = new HugeInteger("1");

        System.out.println("\n\nAdding: " +
                secondHugeInteger.toStringCommaFormat());

        hugeInteger.add(secondHugeInteger);

        System.out.println("\n\nHuge Integer after addition: \n" +
                hugeInteger.toStringCommaFormat());




    }

}
