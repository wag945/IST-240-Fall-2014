
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zfayaz
 */
public class AnimateNumbersTimer extends Timer
{
    private JLabel LabelPScore;
    private int NewScore;
    private boolean AnimatePlusOrMinus;
    private int CurrentScore;
    

    public AnimateNumbersTimer(int i, ActionListener al, JLabel lPScore, int currentScore, int newScore, boolean AnimateScoreOnAdd) 
    {
        super(i, al);
        LabelPScore = lPScore;
        NewScore = newScore;
        CurrentScore = currentScore;
        AnimatePlusOrMinus = AnimateScoreOnAdd;
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
}
