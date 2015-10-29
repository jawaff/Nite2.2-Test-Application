package com.lcsc.hackathon.kinectcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;

import com.primesense.nite.NiTE;
import com.primesense.nite.UserTracker;
import org.openni.Device;
import org.openni.DeviceInfo;
import org.openni.OpenNI;

import javax.swing.JOptionPane;


/**
 * This file and the dependencies wer taken from the Nite2.22 project on BitBucket. That project contained Nite dll/jar files
 * along with the Openni dll/ jar files that were needed for the project.
 *
 * https://bitbucket.org/kaorun55/openni-2.2/src/2f54272802bfd24ca32f03327fbabaf85ac4a5c4/NITE%202.2%20%CE%B1/?at=master
 */
public class UserViewerApplication {
    private JFrame mFrame;
    private UserViewer mViewer;
    private boolean mShouldRun = true;

    public UserViewerApplication(UserTracker tracker) {
        mFrame = new JFrame("NiTE User Tracker Viewer");
        mViewer = new UserViewer(tracker);
        
        // register to key events
        mFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {}
            
            @Override
            public void keyReleased(KeyEvent arg0) {}
            
            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    mShouldRun = false;
                }
            }
        });
        
        // register to closing event
        mFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mShouldRun = false;
            }
        });

        mViewer.setSize(800, 600);
        mFrame.add("Center", mViewer);
        mFrame.setSize(mViewer.getWidth(), mViewer.getHeight());
        mFrame.setVisible(true);
    }

    void run() {
        while (mShouldRun) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mFrame.dispose();
    }

    public static void main(String s[]) {
        // initialize OpenNI and NiTE
    	OpenNI.initialize();
        NiTE.initialize();
        
        List<DeviceInfo> devicesInfo = OpenNI.enumerateDevices();
        if (devicesInfo.size() == 0) {
            JOptionPane.showMessageDialog(null, "No device is connected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Device device = Device.open(devicesInfo.get(0).getUri());
        UserTracker tracker = UserTracker.create();

        final UserViewerApplication app = new UserViewerApplication(tracker);
        app.run();
    }
}
