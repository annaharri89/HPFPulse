package org.humanitypreservationfoundation.pulse.classes;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ETASpare on 3/7/2018.
 */

public class DummyData {
    public static class ALASKA {
        private static final Resource resource1 = new Resource(Config.categories.CHILD_ABUSE, (long) 0, "Helpful Organization 1", "123-456-7890", StateEnum.ALASKA, "https://google.com");
        private static final Resource resource2 = new Resource(Config.categories.BULLYING, (long) 1, "Helpful Organization 2", "123-456-7890", StateEnum.ALASKA, "https://google.com");
        private static final Resource resource3 = new Resource(Config.categories.DOMESTIC_VIOLENCE, (long) 2, "Helpful Organization 3", "123-456-7890", StateEnum.ALASKA, "https://google.com");

        private static List<Resource> getResources() {
            return Arrays.asList(resource1, resource2, resource3);
        }
    }

    public static class CALIFORNIA {
        private static final Resource resource1 = new Resource(Config.categories.CHILD_ABUSE, (long) 3, "Helpful Organization 4", "111-222-3333", StateEnum.CALIFORNIA, "https://google.com");
        private static final Resource resource2 = new Resource(Config.categories.BULLYING, (long) 4, "Helpful Organization 5", "123-456-7890", StateEnum.CALIFORNIA, "https://google.com");
        private static final Resource resource3 = new Resource(Config.categories.DOMESTIC_VIOLENCE, (long) 5, "Helpful Organization 6", "123-456-7890", StateEnum.CALIFORNIA, "https://google.com");

        private static List<Resource> getResources() {
            return Arrays.asList(resource1, resource2, resource3);
        }
    }

    public static class HAWAII {
        private static final Resource resource1 = new Resource(Config.categories.CHILD_ABUSE, (long) 6, "Helpful Organization 7", "444-555-6666", StateEnum.HAWAII, "https://google.com");
        private static final Resource resource2 = new Resource(Config.categories.BULLYING, (long) 7, "Helpful Organization 8", "123-456-7890", StateEnum.HAWAII, "https://google.com");
        private static final Resource resource3 = new Resource(Config.categories.DOMESTIC_VIOLENCE, (long) 8, "Helpful Organization 9", "123-456-7890", StateEnum.HAWAII, "https://google.com");

        private static List<Resource> getResources() {
            return Arrays.asList(resource1, resource2, resource3);
        }
    }

    public static class OREGON {
        private static final Resource resource1 = new Resource(Config.categories.CHILD_ABUSE, (long) 9, "Helpful Organization 10", "777-888-9999", StateEnum.OREGON, "https://google.com");
        private static final Resource resource2 = new Resource(Config.categories.BULLYING, (long) 10, "Helpful Organization 11", "123-456-7890", StateEnum.OREGON, "https://google.com");
        private static final Resource resource3 = new Resource(Config.categories.DOMESTIC_VIOLENCE, (long) 11, "Helpful Organization 12", "123-456-7890", StateEnum.OREGON, "https://google.com");

        private static List<Resource> getResources() {
            return Arrays.asList(resource1, resource2, resource3);
        }
    }

    public static class WASHINGTON {
        private static final Resource resource1 = new Resource(Config.categories.CHILD_ABUSE, (long) 12, "Helpful Organization 13", "765-123-4567", StateEnum.WASHINGTON, "https://google.com");
        private static final Resource resource2 = new Resource(Config.categories.BULLYING, (long) 13, "Helpful Organization 14", "123-456-7890", StateEnum.WASHINGTON, "https://google.com");
        private static final Resource resource3 = new Resource(Config.categories.DOMESTIC_VIOLENCE, (long) 14, "Helpful Organization 15", "123-456-7890", StateEnum.WASHINGTON, "https://google.com");

        private static List<Resource> getResources() {
            return Arrays.asList(resource1, resource2, resource3);
        }
    }

    public static List<Resource> getResources(StateEnum stateEnum) {
        switch (stateEnum) {
            default:
                return null;
            case ALASKA:
                return ALASKA.getResources();
            case CALIFORNIA:
                return CALIFORNIA.getResources();
            case HAWAII:
                return HAWAII.getResources();
            case OREGON:
                return OREGON.getResources();
            case WASHINGTON:
                return WASHINGTON.getResources();
        }
    }

}
