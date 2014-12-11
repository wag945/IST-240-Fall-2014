/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class AnimateNumbersTimer extends Timer
{
    private JLabel LabelPScore;
    private int NewScore;
    private boolean AnimatePlusOrMinus;
    private int CurrentScore;
    private boolean isStopping;
    
    

    public AnimateNumbersTimer(int i, ActionListener al, JLabel lPScore, int currentScore, int newScore, boolean AnimateScoreOnAdd) 
    {
        super(i, al);
        LabelPScore = lPScore;
        NewScore = newScore;
        CurrentScore = currentScore;
        AnimatePlusOrMinus = AnimateScoreOnAdd;
        isStopping = false;
    }

    /**
     * @return the LabelPScore
     */
    public JLabel getLabelPScore() {
        return LabelPScore;
    }

    /**
     * @param LabelPScore the LabelPScore to set
     */
    public void setLabelPScore(JLabel LabelPScore) {
        this.LabelPScore = LabelPScore;
    }

    /**
     * @return the NewScore
     */
    public int getNewScore() {
        return NewScore;
    }

    /**
     * @param NewScore the NewScore to set
     */
    public void setNewScore(int NewScore) {
        this.NewScore = NewScore;
    }

    /**
     * @return the AnimatePlusOrMinus
     */
    public boolean isAnimatePlusOrMinus() {
        return AnimatePlusOrMinus;
    }

    /**
     * @param AnimatePlusOrMinus the AnimatePlusOrMinus to set
     */
    public void setAnimatePlusOrMinus(boolean AnimatePlusOrMinus) {
        this.AnimatePlusOrMinus = AnimatePlusOrMinus;
    }

    /**
     * @return the CurrentScore
     */
    public int getCurrentScore() {
        return CurrentScore;
    }

    /**
     * @param CurrentScore the CurrentScore to set
     */
    public void setCurrentScore(int CurrentScore) {
        this.CurrentScore = CurrentScore;
    }

    /**
     * @return the isStopping
     */
    public boolean isIsStopping() {
        return isStopping;
    }

    /**
     * @param isStopping the isStopping to set
     */
    public void setIsStopping(boolean isStopping) {
        this.isStopping = isStopping;
    }
}
