package main.java.com.phonebookservice.model;

public class SocialProfile {
    private String socialMediaName;
    private String socialProfile;

    /**
     * social profile constructor.
     *
     * @param socialMediaName the social media name.
     * @param socialProfile   social profile.
     */
    public SocialProfile(final String socialMediaName,
            final String socialProfile) {
        this.socialMediaName = socialMediaName;
        this.socialProfile = socialProfile;
    }

}
