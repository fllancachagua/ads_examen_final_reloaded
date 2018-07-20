package scholarship.common.application.enumeration;

public enum StudentType {
	PHD_STUDENT {
        public String toString() {
            return "phd";
        }
    },
	MASTER_STUDENT {
        public String toString() {
            return "master";
        }
    },
	UNDERGRADUATED_STUDENT {
        public String toString() {
            return "undergraduated";
        }
    },
	ALL_STUDENT {
        public String toString() {
            return "all";
        }
    },
}
