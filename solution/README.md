
# Basic Threadwork Notes

Refers to sample code (not in this directory).

>Change some of the data and times in ScheduleTasks to see the effect of the Timer class.

The larger the number the longer the time it takes to print out. The conversation ‘stops’ when the
time in the Thread.sleep method is reached.

>Alter the delay times on the messages in JumbledMessage to see the effect, in both the
unsynchronized and synchronized versions.

In order to see a change you should set a big differences in the delay times (i.e set one to 10 and one
to 1000) . In synchronised version the delay acts as you would expect (i.e. just delays the time that a
message is printed). In the unsynchronised version the longer delay means that the message is more
likely to be printed unjumbled – but certainly doesn’t guarantee it.

# Philosophers Solution

The Philosophers class is the driver class for the problem and all three classes were originally given
for the lecture. Fork has had an accessor added to determine if the Fork is available for pick up. The
run method in Philospher has been altered to call one of runOriginal() [the code given in the lecture],
runRandom() [implements random selection of the first fork to pick up] or randomCheckFirst()
[checks to see if the second fork is available].