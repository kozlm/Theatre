package com.github.kozlm.theatre.validation;

public class Views {
    public interface PlaysAdminView {
    }

    public interface PlaysGuestView extends PlaysAdminView {
    }

    public interface EventsGuestView {
    }

    public interface EventsAdminView extends EventsGuestView {
    }

    public interface AdminView extends PlaysAdminView, EventsAdminView {
    }

    public interface GuestView extends PlaysGuestView, EventsGuestView {
    }

    public interface DtoView {
    }

}
