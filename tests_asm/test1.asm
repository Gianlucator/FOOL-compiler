push 0
push 4
push function0
lfp
push 2
push 1
push -2
lfp
add
lw
lfp
push -3
lfp
add
lw
js
print
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
