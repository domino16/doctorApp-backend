package pl.Dominik.ChatApp.auth;


    public class RegisterRequest {

        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String photoUrl;

        private boolean doctor;

        private int unReadChatsCounter;

        private int visitNotificationsNumber;
        public RegisterRequest() {
        }

        public RegisterRequest(String firstName, String lastName, String email, String password, String photoUrl, boolean doctor, int unReadChatsCounter, int visitNotificationsNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.photoUrl = photoUrl;
            this.doctor = doctor;
            this.unReadChatsCounter = unReadChatsCounter;
            this.visitNotificationsNumber = visitNotificationsNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public boolean isDoctor() {
            return doctor;
        }

        public void setDoctor(boolean doctor) {
            this.doctor = doctor;
        }

        public int getUnReadChatsCounter() {
            return unReadChatsCounter;
        }

        public void setUnReadChatsCounter(int unReadChatsCounter) {
            this.unReadChatsCounter = unReadChatsCounter;
        }

        public int getVisitNotificationsNumber() {
            return visitNotificationsNumber;
        }

        public void setVisitNotificationsNumber(int visitNotificationsNumber) {
            this.visitNotificationsNumber = visitNotificationsNumber;
        }
    }

