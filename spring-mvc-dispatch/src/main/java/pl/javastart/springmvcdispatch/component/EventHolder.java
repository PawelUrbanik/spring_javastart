package pl.javastart.springmvcdispatch.component;

import org.springframework.stereotype.Component;
import pl.javastart.springmvcdispatch.model.Participant;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
public class EventHolder {

    List<Participant> participants;

    public EventHolder() {
        this.participants = new LinkedList<>();
    }

    public void addParticipant(Participant participant){
        this.participants.add(participant);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public boolean checkRegistration(Participant participant)
    {
        return participants.contains(participant);
    }

    @Override
    public String toString() {
        return "EventHolder{" +
                "participants=" + participants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHolder that = (EventHolder) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
