push 0
push 4
push function0
lfp
push -3
lfp
add
lw
lfp
push -4
lfp
add
lw
js
halt

function0:
cfp
lra
push -3
lfp
lw
add
lw
push 1
lfp
add
lw
add
srv
sra
pop
pop
sfp
lrv
lra
js
