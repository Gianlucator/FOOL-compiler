push 8
push function1
push 0
nullnullprint
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 1
beq label0
push -2
lfp
lw
add
lw
b label1
label0:
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
add
lw
add
add
label1:
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push -1
lfp
lw
add
lw
push -2
lfp
lw
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js
