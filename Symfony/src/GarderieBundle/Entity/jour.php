<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * jour
 *
 * @ORM\Table(name="jour")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\jourRepository")
 */
class jour
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="libelleJour", type="string", length=255)
     */
    private $libelleJour;


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
     * Set libelleJour
     *
     * @param string $libelleJour
     *
     * @return jour
     */
    public function setLibelleJour($libelleJour)
    {
        $this->libelleJour = $libelleJour;

        return $this;
    }

    /**
     * Get libelleJour
     *
     * @return string
     */
    public function getLibelleJour()
    {
        return $this->libelleJour;
    }
}

