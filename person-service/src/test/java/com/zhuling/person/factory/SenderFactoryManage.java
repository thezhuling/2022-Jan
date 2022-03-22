package com.zhuling.person.factory;

public class SenderFactoryManage {
    private static class SingletonSmsSenderFactory {
        private static final SenderFactory instance = SmsSenderFactory.getSmsSenderFactoryInstance();

        private static SenderFactory getInstance() {
            return SingletonSmsSenderFactory.instance;
        }
    }

    private static class SingletonEmailFactory {
        private static SenderFactory instance = null;

        private static synchronized void initInstance() {
            if (null == instance) {
                instance = EmailSenderFactory.getEmailSenderFactoryInstance();
            }
        }

        private static SenderFactory getInstance() {
            if (null == instance) {
                initInstance();
            }
            return instance;
        }
    }


    public static SenderFactory getSenderFactory(Class<?> clazz) {
        String name = clazz.getName();
        if (name.equals(EmailSenderFactory.class.getName())) {
            return EmailSenderFactory.getEmailSenderFactoryInstance();
        }

        if (name.equals(SmsSenderFactory.class.getName())) {
            return SmsSenderFactory.getSmsSenderFactoryInstance();
        }

        return null;
    }
}
