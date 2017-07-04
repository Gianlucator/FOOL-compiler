push 0
push 4
push function0
push function1
push function2
lfp
push -2
lfp
add
lw
push 1
push -2
lfp
add
lw
lfp
push -5
lfp
add
lw
js
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 5
lfp
lfp
push -2
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
lfp
lw
push -3
lfp
lw
add
lw
js
srv
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js
