package ch.axa.backend.mongo.model;

import org.springframework.data.annotation.Id;

public class Termin {

        @Id
        private String id;

        private String name;
        private String time;

        public Termin() {

        }

        public Termin(String name, String time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String toString() {
            return String.format("Termin[id=%s, name='%s', time='%s']", id, name, time);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
}
