package pl.Dominik.ChatApp.user;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")

public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String email;

//    @NotBlank
    private String password;
//    @NotBlank

    private String firstName;
//    @NotBlank

    private String lastName;
//    @NotBlank

    private String photoUrl;

    private boolean doctor;

    private int unReadChatsCounter;

    private int visitNotificationsNumber;


//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_visits", joinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Visits> visits = new ArrayList<>();

    public User() {

    }

    public User(String email, String password, String firstName, String lastName, String photoUrl, boolean doctor, int unReadChatsCounter, int visitNotificationsNumber) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.doctor = doctor;
        this.unReadChatsCounter = unReadChatsCounter;
        this.visitNotificationsNumber = visitNotificationsNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Visits> getVisits() {
        return visits;
    }

    public void setVisits(List<Visits> visits) {
        this.visits = visits;
    }

    //  @Enumerated(EnumType.STRING)
//  private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
