package com.example.mobapp;

import android.os.Handler;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import timber.log.Timber;

public class Timer implements LifecycleObserver
{
    private long startTimeInSeconds;
    private long currentActiveTimeInSeconds = 0;

    Handler handler = new Handler();
    Runnable runnable;

    int delay = 1000; // in milliseconds

    public long getStartTimeInSeconds() {
        return startTimeInSeconds;
    }

    public void RegisterLifecycle(Lifecycle lifecycle)
    {
        lifecycle.addObserver(this);
    }

    public void SetStartTime() {
        this.startTimeInSeconds = GetCurrentTimeInSeconds();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void PauseTimer()
    {
        handler.removeCallbacks(runnable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ResumeTimer()
    {
        handler.postDelayed(runnable = new Runnable()
        {
            public void run()
            {
                handler.postDelayed(runnable, delay);
                Timber.d("Current focus time = " + currentActiveTimeInSeconds);
                currentActiveTimeInSeconds++;
            }
        }, delay);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void DisplayInfo()
    {
        long currentTime = GetCurrentTimeInSeconds();
        long totalUseTime = Math.abs(currentTime - startTimeInSeconds);

        float ratio = currentActiveTimeInSeconds / (float)totalUseTime;
        Timber.d(String.valueOf(ratio));
        Timber.d(String.valueOf((int)(ratio * 100)));
    }

    private long GetCurrentTimeInSeconds()
    {
        return System.currentTimeMillis() / 1000;
    }
}
