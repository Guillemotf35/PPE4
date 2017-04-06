<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Presence
 *
 * @ORM\Table(name="presence")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\PresenceRepository")
 */
class Presence
{

     /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\enfant")
    * @ORM\JoinColumn(nullable=false)
    */
    private $enfant;

    /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\jour")
    * @ORM\JoinColumn(nullable=false)
    */
    private $jour;
    
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureArriveeMatin", type="time")
     */
    private $heureArriveeMatin;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureDepartSoir", type="time")
     */
    private $heureDepartSoir;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date")
     */
    private $date;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set heureArriveeMatin
     *
     * @param \DateTime $heureArriveeMatin
     *
     * @return Presence
     */
    public function setHeureArriveeMatin($heureArriveeMatin)
    {
        $this->heureArriveeMatin = $heureArriveeMatin;

        return $this;
    }

    /**
     * Get heureArriveeMatin
     *
     * @return \DateTime
     */
    public function getHeureArriveeMatin()
    {
        return $this->heureArriveeMatin;
    }

    /**
     * Set heureDepartSoir
     *
     * @param \DateTime $heureDepartSoir
     *
     * @return Presence
     */
    public function setHeureDepartSoir($heureDepartSoir)
    {
        $this->heureDepartSoir = $heureDepartSoir;

        return $this;
    }

    /**
     * Get heureDepartSoir
     *
     * @return \DateTime
     */
    public function getHeureDepartSoir()
    {
        return $this->heureDepartSoir;
    }

    /**
     * Set date
     *
     * @param \DateTime $date
     *
     * @return Presence
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set enfant
     *
     * @param \GarderieBundle\Entity\enfant $enfant
     *
     * @return Presence
     */
    public function setEnfant(\GarderieBundle\Entity\enfant $enfant)
    {
        $this->enfant = $enfant;

        return $this;
    }

    /**
     * Get enfant
     *
     * @return \GarderieBundle\Entity\enfant
     */
    public function getEnfant()
    {
        return $this->enfant;
    }

    /**
     * Set jour
     *
     * @param \GarderieBundle\Entity\jour $jour
     *
     * @return Presence
     */
    public function setJour(\GarderieBundle\Entity\jour $jour)
    {
        $this->jour = $jour;

        return $this;
    }

    /**
     * Get jour
     *
     * @return \GarderieBundle\Entity\jour
     */
    public function getJour()
    {
        return $this->jour;
    }
}
