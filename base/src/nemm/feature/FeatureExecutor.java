package nemm.feature;

import nemm.http.exception.No200Exception;

/**
 * Feature Executor
 * @author chsungyesuzuki
 * @since 0.0.2
 */
public final class FeatureExecutor{
    /**
     * nts
     * @since 0.0.2
     * @param splitCmd nts
     */
    public static void execute(String[]splitCmd){
        Feature feature=switch(splitCmd[0]){
            case"help"->new Help();
            case"fork"->new Fork();
            case"login"->new Login();
            case"exit"->new Exit();
            case"setDefaultDescription"->new SetDefaultDescription();
            default->throw new IllegalArgumentException();
        };
        try{
            feature.execute(splitCmd);
        }catch(No200Exception e){
            if(e.response.statusCode()==301){
                System.err.println("login first please!");
            }else{
                throw e;
            }
        }
    }
}
