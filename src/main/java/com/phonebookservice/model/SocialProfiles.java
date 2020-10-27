package main.java.com.phonebookservice.model;

public class SocialProfiles {
    private String socialMediaName;
    private String socialprofile;

    public SocialProfiles(final String socialMediaName, final String socialprofile) {
        this.socialMediaName = socialMediaName;
        this.socialprofile = socialprofile;
    }

    public String getSocialMediaName() {
        return socialMediaName;
    }

    public void setSocialMediaName(final String socialMediaName) {
        this.socialMediaName = socialMediaName;
    }

    public String getSocialprofile() {
        return socialprofile;
    }

    public void setSocialprofile(final String socialprofile) {
        this.socialprofile = socialprofile;
    }

}
