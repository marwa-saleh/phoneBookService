package main.java.com.phonebookservice.model;

public class SocialProfile {
    /**
     * social media name.
     */
    private String socialMediaName;
    /**
     * social profile.
     */
    private String socialProfile;

    /**
     * social profile constructor.
     *
     * @param socialMediaNameValue the social media name.
     * @param socialProfileValue   social profile.
     */
    public SocialProfile(final String socialMediaNameValue,
            final String socialProfileValue) {
        this.socialMediaName = socialMediaNameValue;
        this.socialProfile = socialProfileValue;
    }

}
