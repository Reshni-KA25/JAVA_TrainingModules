package com.kanini.CustomExceptions;

public class PaymentExceptions {

    public static class PaymentFailedException extends Exception {
        private final int errorCode;

        public PaymentFailedException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return errorCode;
        }
    }

    public static class InvalidOrderException extends PaymentFailedException {
        public InvalidOrderException(String message, int errorCode) {
            super(message, errorCode);
        }
    }

    public static class InvalidUPIIDException extends PaymentFailedException {
        public InvalidUPIIDException(String message, int errorCode) {
            super(message, errorCode);
        }
    }

    public static class InvalidPINException extends PaymentFailedException {
        public InvalidPINException(String message, int errorCode) {
            super(message, errorCode);
        }
    }

    public static class InvalidAmountException extends PaymentFailedException {
        public InvalidAmountException(String message, int errorCode) {
            super(message, errorCode);
        }
    }

    public static class UPIServiceFailedException extends PaymentFailedException {
        public UPIServiceFailedException(String message, int errorCode) {
            super(message, errorCode);
        }
    }
}
